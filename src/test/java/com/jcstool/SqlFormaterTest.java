package com.jcstool;

import com.jcstool.util.FileUtil;
import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.util.List;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/26
 * @Desoription :
 */
public class SqlFormaterTest {

    @Test
    public void test(){
        String file = "D:\\main\\qinjiawang\\project\\wlj-orders\\docs\\sql.txt";
        List<String> list = FileUtil.readFileByLines(file);
        FileUtil.append(file,"n");

        FileUtil.append(file,"StringBuffer sb = new StringBuffer();");
        for (String s : list){
            if(s==null)continue;
            if(s.trim().equals(""))continue;
            s = s.replaceAll("\"","'");
            String line = "sb.append(\""+s+" \");";
            FileUtil.append(file,line);
        }
    }

    @Test
    public void testStr(){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        sb.append("	'yycg' scene_industry_code, ");
        sb.append("	c.id scene_task_no, ");
        sb.append("	o.source task_src, ");
        sb.append("	DATE_FORMAT( NOW( ), '%Y-%m-%d %H:%i:%s' ) task_time, ");
        sb.append("	c.task_content task_content, ");
        sb.append("	o.venue_name enty_name, ");
        sb.append("	c.check_dept fq_dept, ");
        sb.append("	'wlj' distribute_dept_code, ");
        sb.append("	'文体旅游局' check_dept, ");
        sb.append("	c.check_user_name check_user_name, ");
        sb.append("	c.check_user_phone check_user_phone, ");
        sb.append("	DATE_FORMAT( NOW( ), '%Y-%m-%d %H:%i:%s' ) update_time, ");
        sb.append("	'E' isdel, ");
        sb.append("	c.venue_id venue_id ");
        sb.append("FROM ");
        sb.append("	check_task c ");
        sb.append("INNER JOIN work_order o ON o.venue_id=c.venue_id ");
        System.out.println(sb.toString());
    }


}
