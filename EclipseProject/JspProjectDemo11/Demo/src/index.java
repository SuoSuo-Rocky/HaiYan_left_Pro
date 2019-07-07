
public class index {
	   String  a = "wang";
	
	private void inner(String a){
	    System.out.println("在函数内部修改之前,变量a的内存地址为： "+System.identityHashCode(a));
	    a = "liyuan";
	    System.out.println("在函数内部修改之后,变量a的内存地址为：" +System.identityHashCode(a));
	    System.out.println("函数内部的a为： " +a);
	}
	
	

	public static void main(String[] args) {
     index shi = new index();
//     System.out.println(a.hashCode());
     System.out.println("调用函数之前,变量a的内存地址为： "+System.identityHashCode(shi.a));
     shi.inner(shi.a);
     System.out.println("函数外部的a为： " +shi.a);
	}

}
