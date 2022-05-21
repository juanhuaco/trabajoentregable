package ejercicio_integrador;

import ejercicio_integrador.exceptions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.OptionalDouble;
import java.util.function.*;

public class Factura{
	static private int _id = 1;
	private int id;
	private double montoTotal;
	private ArrayList<Bien> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private Date fecha;
	
	
	public int getId() {
		return id;
	}
	public ArrayList<Bien> getBienes() {
		return bienes;
	}
	public double getMontoTotal() {
		return this.montoTotal;
	}
	private double getMontoTotalInterno() {
		Proveedor p = this.proveedor;
		Responsable r = this.responsable;
		ArrayList<Bien> bienes = this.bienes;
		
		double montoTotal = 0d;
		
		Supplier<Double> calcularMontoBruto = () -> {
			OptionalDouble ret = bienes.stream()
						 	           .mapToDouble(b -> b.getPrecio())
					      	           .reduce((acum, ant) -> {return acum+ant;});
			double value = ret.orElse(-1);
			return value;
		};
		BiFunction<Double, Integer, Double> sumarPorcentaje = (monto, porcentaje) -> monto * (1 + porcentaje/100d); 
		
		montoTotal = calcularMontoBruto.get();
		
		if       (p.mismaLocalidad(r))  montoTotal = sumarPorcentaje.apply(montoTotal, 10);
		else if  (p.mismaProvincia(r))  montoTotal = sumarPorcentaje.apply(montoTotal, 30);
		else if  (p.mismoPais(r))       montoTotal = sumarPorcentaje.apply(montoTotal, 70);
		
		if       (bienes.size() > 10)   montoTotal = sumarPorcentaje.apply(montoTotal, -20);
		else if  (bienes.size() > 5)    montoTotal = sumarPorcentaje.apply(montoTotal, -10);
		
		
		return montoTotal;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Factura(ArrayList<Bien> bienes, Responsable responsable, Proveedor proveedor, Date fecha) throws Exception{
		super();
		try{
			
			if(! proveedor.mismoPais(responsable)) throw new PaisesDistintosProveedorResponsableException("Proveedor y Responsable en Distintos Paises");
			if(bienes.size() > 20) throw new FacturaMasDe20ElementosException("Factura Mas de 20 elementos.");
			
			this.id = Factura._id;
			Factura._id++;
			this.bienes = bienes;
			this.responsable = responsable;
			this.proveedor = proveedor;
			this.fecha = fecha;
			this.montoTotal = this.getMontoTotalInterno();
		}
		catch(PaisesDistintosProveedorResponsableException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(FacturaMasDe20ElementosException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
