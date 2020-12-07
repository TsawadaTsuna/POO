public class Libro{//Hecho por Kevin Contreras A01635597
	private String titulo,
				   autor,
				   editorial,
				   isbn;

	public Libro(){//Constructor default
		titulo = "Libro de muestra";
		autor = "Desconocido";
		editorial = "Editorial generica";
		isbn = "";
	}

	public Libro(String titu,String aut,String ed,String isb){//Constructor de 4 parametros
		titulo = titu;
		autor = aut;
		editorial = ed;
		isbn = isb;
	}

	public String getAutor(){//Getter para el autor
		return autor;
	}

	public String getTitulo(){//Getter para el titulo
		return titulo;
	}

	public String getEditorial(){//Getter para la editorial
		return editorial;
	}

	public String getIsbn(){//Getter para el isbn
		return isbn;
	}

	public void setTitulo(String titu){//Setter para el Titulo
		titulo = titu;
	}

	public void setAutor(String aut){//Setter para el autor
		autor = aut;
	}

	public void setEditorial(String ed){//Setter para la editorial
		editorial = ed;
	}

	public void setIsbn(String isb){//Setter para el isbn
		isbn = isb;
	}

	public static void main(String[] args){
		Libro libro1 = new Libro();//Objeto 1
		Libro libro2 = new Libro("P.O.O.", "Oracle", "Java", "123-45-67890-12-3");//Objeto 2

		//Pruebas:
		System.out.println("Autor Libro1: "+libro1.getAutor());
		System.out.println("Titulo Libro1: "+libro1.getTitulo());
		System.out.println("Editorial Libro1: "+libro1.getEditorial());
		System.out.println("Isbn Libro1: "+libro1.getIsbn());

		System.out.println("Autor Libro2: "+libro2.getAutor());
		System.out.println("Titulo Libro2: "+libro2.getTitulo());
		System.out.println("Editorial Libro2: "+libro2.getEditorial());
		System.out.println("Isbn Libro2: "+libro2.getIsbn());

		libro1.setAutor("Yo mero");
		libro1.setTitulo("Objeto: libro");
		libro1.setEditorial("Editorial OBJETO");
		libro1.setIsbn("113-55-66720-32-8");

		libro2.setAutor("Anonimo");
		libro2.setTitulo("El libro sin nombre");
		libro2.setEditorial("Editorial oculta");
		libro2.setIsbn("001-11-10011-10-0");

		System.out.println("Autor Libro1: "+libro1.getAutor());
		System.out.println("Titulo Libro1: "+libro1.getTitulo());
		System.out.println("Editorial Libro1: "+libro1.getEditorial());
		System.out.println("Isbn Libro1: "+libro1.getIsbn());

		System.out.println("Autor Libro2: "+libro2.getAutor());
		System.out.println("Titulo Libro2: "+libro2.getTitulo());
		System.out.println("Editorial Libro2: "+libro2.getEditorial());
		System.out.println("Isbn Libro2: "+libro2.getIsbn());
	}
	/*  
	Esta tarea me ayudo a comprender mejor los objetos y como usarlos, asi como recordar el funcionamiento de los atributos.
	Considero que en esta tarea mejore en la organizacion de mi codigo para que sea mas presentable y facil de leer.
	*/
}