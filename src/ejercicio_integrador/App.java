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
		
		ArrayList<Bien> bienesProveedor = new ArrayList<>();
		
		
		Bien b1 = new Bien("b1", "desc1", 1d, responsable1);
		Bien b2 = new Bien("b2", "desc2", 2d, responsable1);
		Bien b3 = new Bien("b3", "desc3", 3d, responsable1);
		
		bienesProveedor.add(b1);
		bienesProveedor.add(b2);
		bienesProveedor.add(b3);
		
		Proveedor proveedor1 = new Proveedor("tomas", sunchales, bienesProveedor);
		Proveedor proveedor2 = new Proveedor("juan", sunchales, bienesProveedor);
		Proveedor proveedor3 = new Proveedor("luna", sunchales, bienesProveedor);
		
		
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

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
