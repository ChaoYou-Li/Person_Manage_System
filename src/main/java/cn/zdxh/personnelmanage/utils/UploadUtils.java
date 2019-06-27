package cn.zdxh.personnelmanage.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 图片上传工具类
 */
public class UploadUtils {
    public static String  getFileName(String originalName){
        //原始文件名
        //切割图片的类型
        String formatName = originalName.substring(originalName.lastIndexOf('.'), originalName.length());
        //新建文件名
        String fileName= UUID.randomUUID().toString()+formatName;
        return fileName;
    }


    /**
     * 功能分析：把Excel表中的数据封装为一个字符串数组集合中（每一行对应一个数组）
     * @param file
     * @param start
     * @return
     * @throws Exception
     */
    public List<String[]> updateExcelUtils(MultipartFile file, int start) throws Exception {

        boolean notNull=false;    //判断Excel文件是否有内容
        List<String[]> list = null;
        String filename=file.getOriginalFilename();//获取上传文件的名字

        if (!filename.matches("^.+\\.(?i)(xls)$") && !filename.matches("^.+\\.(?i)(xlsx)$")){
            throw new Exception("上传文件格式不正确");
        }

        //判断Excel文件的版本
        boolean isExcel2003=true;
        if (filename.matches("^.+\\.(?i)(xlsx)$")){
            isExcel2003 = false;
        }

        //获取Excel文件的输入流
        InputStream is=file.getInputStream();
        //设置Excel对象
        Workbook wb=null;
        //先判断是哪个版本的Excel表
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            //2007以后版本
            wb = new XSSFWorkbook(is);
        }

        //获取Excel文件的第一页sheet，判断是否有信息
        Sheet sheet=wb.getSheetAt(0);
        if (sheet != null){
            notNull = true;//sheet内容不为空
        }

        if (notNull){//上传的Excel文件不为空时才启动
            //遍历Excel文件
            int totalRows = sheet.getPhysicalNumberOfRows();	//获取行数，第一行是标题
            //初始化字符串数组集合
            list = new ArrayList<String[]>();

            //设置一个对Excel表的行操作对象
            Row row=null;
            //设置一个代表每一个的列元素变量
            int totalCells=0;
            //变量Excel表
            for (int i=start; i<totalRows; i++){
                //获取Excel表中的每一个行单元数据
                row=sheet.getRow(i);
                //获取每一行中的列单元个数
                totalCells = row.getPhysicalNumberOfCells();
                //循环设置每个单元格的数据类型为String类型
                for (int j=0; j<totalCells; j++){
                    if (row.getCell(j) != null){
                        //设置每一个单元格的类型
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                    }
                }

                //创建一个数组存放每一行的数据
                String[] str = new String[totalCells];

                //获取每个单元格的数据，保存到集合中
                for (int z=0; z<totalCells; z++){
                    //判断单元格类型是否为空
                    if (row.getCell(z, row.RETURN_BLANK_AS_NULL) == null){
                        //如果单元格为空则写入"NULL"
                        row.createCell(z).setCellValue("NULL");
                    }
                    //判断单元格内容是否为空
                    String cellInfo = row.getCell(z).getStringCellValue();
                    //StringUtils 有Apache提供的对字符串操作的工具类，isBlank方法是用来判断该字符串是否含有数据
                    if (StringUtils.isBlank(cellInfo)){
                        cellInfo = "NULL";

                    }
                    //把一行中的每个单元格写入一个数组中
                    str[z] = cellInfo;
                }
                //把每个代表行数据的字符串数组存放入集合中
                list.add(str);
            }
            //关闭输入流
            is.close();
        }
        //返回该数组集合
        return list;
    }
}
