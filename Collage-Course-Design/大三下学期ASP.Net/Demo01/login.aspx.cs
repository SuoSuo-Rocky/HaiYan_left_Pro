using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class login : System.Web.UI.Page
{
    static SqlConnection conn;
    static SqlDataReader res;
    static String connStr = "Server=.;Database=myblogs;uid=sa;pwd=123456789";

    static String username;
    static String password;
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {

         username = TextBox1.Text;
         password = TextBox2.Text;


        conn = new SqlConnection(connStr);

        conn.Open();
        String sql = @"select * from login where username= '" + username + "'  and password='" + password + "'";


        SqlCommand cmd = new SqlCommand(sql, conn);
        cmd.Connection = conn;
        res = cmd.ExecuteReader();

        Response.Write("Change is------->" + res);
        //cmd.CommandText = "INSERT INTO 表名(字段名一，字段名二)VALUES(@参数一，@参数二)"；
        //cmd.Parameters.Add("@参数一"，SqlDbType.Char).Value = TextBox1.Text.Trim()；
        //cmd.Parameters.Add("@参数二"，SqlDbType.Char).Value = TextBox2.Text.Trim()；
        //int var = cmd.ExecuteNonQuery()； //执行数据库命令
        if (res.Read()) //判断数据库命令是否执行成功
        {
            conn.Close();
            Response.Write("<script>alert('登录成功！');location.href='Default.aspx'</script>");
        } 
    }
}