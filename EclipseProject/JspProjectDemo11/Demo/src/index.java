
public class index {
	   String  a = "wang";
	
	private void inner(String a){
	    System.out.println("�ں����ڲ��޸�֮ǰ,����a���ڴ��ַΪ�� "+System.identityHashCode(a));
	    a = "liyuan";
	    System.out.println("�ں����ڲ��޸�֮��,����a���ڴ��ַΪ��" +System.identityHashCode(a));
	    System.out.println("�����ڲ���aΪ�� " +a);
	}
	
	

	public static void main(String[] args) {
     index shi = new index();
//     System.out.println(a.hashCode());
     System.out.println("���ú���֮ǰ,����a���ڴ��ַΪ�� "+System.identityHashCode(shi.a));
     shi.inner(shi.a);
     System.out.println("�����ⲿ��aΪ�� " +shi.a);
	}

}
