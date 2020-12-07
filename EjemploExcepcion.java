public class EjemploExcepcion {
    public void a() throws Exception{
        b();
    }
    public void b()throws Exception{
        c();
    }
    public void c() throws Exception{
        d();
    }
    public  void d() throws Exception{
        throw new Exception("Error en d");
    }
    public static void main(String[] Args){
        EjemploExcepcion ee = new EjemploExcepcion();
        try {
            ee.a();
        }catch (Exception ex){
            System.out.println("Nada");
        }
    }
}
