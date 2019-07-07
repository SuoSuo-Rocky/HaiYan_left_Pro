using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class comments_add : System.Web.UI.Page
{
    static SqlConnection conn;
    static SqlDataReader res;
    static String aaa = "shiwei";
    static String connStr = "Server=.;Database=myblogs;uid=sa;pwd=123456789";

    static String sql02 = "select * from articles where id = ";
    int id = 1;
    protected void Page_Load(object sender, EventArgs e)
    {
        String sql01 = "update articles set ";
        conn = new SqlConnection(connStr);
        conn.Open();
        int comments_num = Convert.ToInt32(Request.QueryString["comments_num"]) + 1;


        // 查询当前的 赞数
        sql01 = sql01 + " comments=" + "'" + Convert.ToString(comments_num) + "'";
        Response.Write("id ------>" + Request.QueryString["id"]);
        Response.Write("comments------>" + Convert.ToString(comments_num));
        sql01 = sql01 + " where id=" + Request.QueryString["id"];
        SqlCommand cmd = new SqlCommand(sql01, conn);
        cmd.Connection = conn;
        int res = cmd.ExecuteNonQuery();

        if (res > 0) //判断数据库命令是否执行成功
        {
            conn.Close();
            Response.Write("<script>location.href='Default.aspx'</script>");
        }

    }
}