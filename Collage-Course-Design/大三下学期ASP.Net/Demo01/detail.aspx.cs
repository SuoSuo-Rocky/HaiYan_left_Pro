using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

public partial class detail : System.Web.UI.Page
{
    static SqlConnection conn;
    static SqlDataReader res;
    static String aaa = "shiwei";
    static String connStr = "Server=.;Database=myblogs;uid=sa;pwd=123456789";
    static String sql02 = "select * from articles where id = ";
    int id = 1;
    protected void Page_Load(object sender, EventArgs e)
    {
        int id = Convert.ToInt32(Request.QueryString["id"]);

    }

    protected void Button4_Click(object sender, EventArgs e)
    {
        sql02 = sql02 + Convert.ToString(id);
        SqlCommand comn = new SqlCommand(sql02, conn);
        res = comn.ExecuteReader();


        while (res.Read())
        {
            String line = " ";
            Int32 userid = res.GetInt32(0);
            String username = res[1].ToString().Trim();
            Int32 userage = res.GetInt32(2);
            line = userid + username + userage;
            Response.Write(line + "<br>");
        }


    }
}