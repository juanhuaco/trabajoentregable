package ejercicio_integrador;

import java.util.ArrayList;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		Pais argentina = new Pais("Argentina");
		Pais brasil = new Pais("Brasil");
		
		Provincia rioGrande = new Provincia("Rio Grande do Sul", brasil);
		Provincia santaFe = new Provincia("Santa Fe", argentina);
		Provincia cordoba = new Provincia("Cordoba", argentina);
		
		Localidad portoAlegre = new Localidad("Porto Alegre", rioGrande, brasil);
		
		Localidad rafaela = new Localidad("Rafaela", santaFe, argentina);
		Localidad sunchales = new Localidad("Sunchales", santaFe, argentina);
		Localidad villaMaria = new Localidad("VillaMaria", cordoba, argentina);
		
		
		Responsable responsable1 = new Responsable("Juan", sunchales, "Santelmo");
		
		ArrayList<Bien> bienesProveedor = new ArrayList<>();
		
		
		Bien b1 = new Bien("b1", "desc1", 1d, responsable1);
		Bien b2 = new Bien("b2", "desc2", 2d, responsable1);
		Bien b3 = new Bien("b3", "desc3", 3d, responsable1);
		
		bienesProveedor.add(b1);
		bienesProveedor.add(b2);
		bienesProveedor.add(b3);
		
		Proveedor proveedor1 = new Proveedor("tomas", sunchales, bienesProveedor);
		
		try {
			//==========Responsable y Proveedor igual Localidad=============
			Factura f1 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());
			
			System.out.println("Responsable y Proveedor igual Localidad");
			System.out.println(f1.getMontoTotal());
			
			//==========Responsable y Proveedor igual Provincia=============
			responsable1.setLocalidad(rafaela);
			Factura f2 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());
			
			System.out.println("Responsable y Proveedor igual Provincia");
			System.out.println(f2.getMontoTotal());
			
			
			//==========Responsable y Proveedor igual Pais=============
			responsable1.setLocalidad(villaMaria);
			Factura f3 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());
			
			System.out.println("Responsable y Proveedor igual Pais: " + f3.getMontoTotal());
			
			//==========Responsable y Proveedor Distinto Pais=============
			responsable1.setLocalidad(portoAlegre);
			Factura f4 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());
			responsable1.setLocalidad(sunchales);
			//==========>5 elementos=============
			
			for(int i=0; i<3; i++) bienesProveedor.add(b1);
			
			Factura f5 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());
			
			System.out.println("Mas de 5 bienes: " + f5.getMontoTotal());
			
			//==========>10 elementos=============
			
			for(int i=0; i<5; i++) bienesProveedor.add(b1);
			
			Factura f6 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());
			
			System.out.println("Mas de 10 bienes: " + f6.getMontoTotal());
			
			//==========>20 elementos=============
			for(int i=0; i<10; i++) bienesProveedor.add(b1);
			
			Factura f7 = new Factura(bienesProveedor, responsable1, proveedor1, new Date());

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
