package cn.zdxh.personnelmanage.utils;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

public class ExportExcelUtils {
    public static void createExcelUtils(List<Object[]> values, String[] titles, HttpServletResponse httpServletResponse) throws IllegalAccessException, InstantiationException {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("会议签到表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式


        //第五步，创建标题
        for (int i =0 ; i < titles.length ; i++){
            HSSFCell cell = row.createCell((short) i);
            cell.setCellValue(titles[i]);
        }



        //第六步，写入实体数据，遍历创建内容
        for(int i=0;i<values.size();i++){//总共多少行
            Object[] str = values.get(i);
            row = sheet.createRow(i + 1);//第几行
            for(int j=1;j<str.length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j-1).setCellValue(str[j].toString());//每行塞什么数据
            }
        }

        //第六步，下载excel表格
        OutputStream out = null;
        try {
            out = httpServletResponse.getOutputStream();
            String fileName = UUID.randomUUID().toString()+".xls";// 文件名
            httpServletResponse.setContentType("application/x-msdownload");//文件格式
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));//响应头以及文件名，编码格式
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}









