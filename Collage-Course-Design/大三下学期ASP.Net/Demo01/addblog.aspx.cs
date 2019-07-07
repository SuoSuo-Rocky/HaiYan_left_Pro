using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class addblog : System.Web.UI.Page
{
    static SqlConnection conn;
    static SqlDataReader res;
    static String connStr = "Server=.;Database=myblogs;uid=sa;pwd=123456789";
    


    static String title;
    static String introduce;
    static String classes;
    

    protected void Page_Load(object sender, EventArgs e)
    {
        title = TextBox1.Text;
        introduce = TextBox1.Text;
        classes = TextBox1.Text;
    
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        conn =new  SqlConnection(connStr);
        
        conn.Open();
        String sql = @"insert into articles(title,introduce,classes) values ('"  + title + "','" + introduce  + "','" + classes + "')";


        SqlCommand cmd = new SqlCommand(sql, conn);
        cmd.Connection = conn;
        int res = cmd.ExecuteNonQuery();

        //cmd.CommandText = "INSERT INTO 表名(字段名一，字段名二)VALUES(@参数一，@参数二)"；
        //cmd.Parameters.Add("@参数一"，SqlDbType.Char).Value = TextBox1.Text.Trim()；
        //cmd.Parameters.Add("@参数二"，SqlDbType.Char).Value = TextBox2.Text.Trim()；
        //int var = cmd.ExecuteNonQuery()； //执行数据库命令
        if (res > 0) //判断数据库命令是否执行成功
        {
            conn.Close();
            Response.Write("<script>alert('数据添加成功！');location.href='Default.aspx'</script>");
        } 

    }
}