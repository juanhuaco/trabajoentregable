package ejercicio_integrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

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
		
		ArrayList<Bien> bienesProveedor1 = new ArrayList<>();

		ArrayList<Bien> bienesProveedor5 = new ArrayList<>();
		ArrayList<Bien> bienesProveedor6 = new ArrayList<>();
		ArrayList<Bien> bienesProveedor7 = new ArrayList<>();
		
		Bien b1 = new Bien("b1", "desc1", 1d, responsable1);
		Bien b2 = new Bien("b2", "desc2", 2d, responsable1);
		Bien b3 = new Bien("b3", "desc3", 3d, responsable1);
		
		bienesProveedor1.add(b1);
		bienesProveedor1.add(b2);
		bienesProveedor1.add(b3);
		
		Proveedor proveedor1 = new Proveedor("tomas", sunchales, bienesProveedor1);
		Proveedor proveedor2 = new Proveedor("juan", sunchales, bienesProveedor1);
		Proveedor proveedor3 = new Proveedor("luna", sunchales, bienesProveedor1);
		
		Date date1 = new Date(100000000);
		Date date2 = new Date(200000000);
		Date date3 = new Date(300000000);
		Date date4 = new Date(400000000);
		Date date5 = new Date(500000000);
		Date date6 = new Date(600000000);
		Date date7 = new Date(700000000);
		
		try {
			//==========Responsable y Proveedor igual Localidad=============
			Factura f1 = new Factura(bienesProveedor1, responsable1, proveedor1, date1);
			
			System.out.println("Responsable y Proveedor igual Localidad");
			System.out.println(f1.getMontoTotal());
			
			//==========Responsable y Proveedor igual Provincia=============
			responsable1.setLocalidad(rafaela);
			Factura f2 = new Factura(bienesProveedor1, responsable1, proveedor1, date2);
			
			System.out.println("Responsable y Proveedor igual Provincia");
			System.out.println(f2.getMontoTotal());
			
			
			//==========Responsable y Proveedor igual Pais=============
			responsable1.setLocalidad(villaMaria);
			Factura f3 = new Factura(bienesProveedor1, responsable1, proveedor1, date3);
			
			System.out.println("Responsable y Proveedor igual Pais: " + f3.getMontoTotal());
			
			//==========Responsable y Proveedor Distinto Pais=============
			responsable1.setLocalidad(portoAlegre);
			Factura f4 = new Factura(bienesProveedor1, responsable1, proveedor1, date4);
			responsable1.setLocalidad(sunchales);
			//==========>5 elementos=============
			
			for(int i=0; i<6; i++) bienesProveedor5.add(b1);
			
			Factura f5 = new Factura(bienesProveedor5, responsable1, proveedor1, date5);
			
			System.out.println("Mas de 5 bienes: " + f5.getMontoTotal());
			
			//==========>10 elementos=============
			
			for(int i=0; i<11; i++) bienesProveedor6.add(b1);
			
			Factura f6 = new Factura(bienesProveedor6, responsable1, proveedor1,date6);
			
			System.out.println("Mas de 10 bienes: " + f6.getMontoTotal());
			
			//==========>20 elementos=============
			for(int i=0; i<21; i++) bienesProveedor7.add(b1);
			
			Factura f7 = new Factura(bienesProveedor7, responsable1, proveedor1, date7);
			
			//=============> listarFacturaByProveedor(Proveedor p)=======
			
			ArrayList<Responsable> responsablesEmpresa = new ArrayList<Responsable>();
			responsablesEmpresa.add(responsable1);
			
			ArrayList<Proveedor> proveedoresEmpresa = new ArrayList<Proveedor>();
			proveedoresEmpresa.add(proveedor1);
			proveedoresEmpresa.add(proveedor2);
			proveedoresEmpresa.add(proveedor3);
			
			ArrayList<Bien> bienesEmpresa = new ArrayList<Bien>();
			bienesEmpresa.add(b1);
			bienesEmpresa.add(b2);
			bienesEmpresa.add(b3);
			
			ArrayList<Factura> facturasEmpresa = new ArrayList<Factura>();
			facturasEmpresa.add(f1);
			facturasEmpresa.add(f2);
			facturasEmpresa.add(f3);
			facturasEmpresa.add(f5);
			facturasEmpresa.add(f6);
			
			Empresa empresa = new Empresa(responsablesEmpresa, proveedoresEmpresa, bienesEmpresa, facturasEmpresa);
			
			System.out.println("Faturas por Proveedor");
			System.out.println(empresa.listarFacturaByProveedor(proveedor1).stream().map(f -> f.getId()).collect(Collectors.toList()));
			
			System.out.println("Faturas por Responsable");
			System.out.println(empresa.listarFacturaByResponsable(responsable1).stream().map(f -> f.getId()).collect(Collectors.toList()));
			
			System.out.println("Proveedores por orden Lexicografico");
			System.out.println(empresa.listarNombresProveedores(sunchales));
			
			System.out.println("Bienes cuyo proveedor reside en Loalidad");
			System.out.println(empresa.listarBienesByLocalidad(sunchales));
			
			System.out.println("Bienes cuyo preio es mayor a pm");
			System.out.println(empresa.listarBienesByPrecioMayor(1d));

			System.out.println("Facturas cuyo monto es mayor a mm");
			System.out.println(empresa.listarFacturasByMontoMayor(10d));
			
			System.out.println("Facturas de p ordenadas por date");
			System.out.println(empresa.listarFactuadasPorProveedor(proveedor1));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
