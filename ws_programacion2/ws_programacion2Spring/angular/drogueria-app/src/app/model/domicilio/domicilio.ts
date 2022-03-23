import { Cliente } from "../cliente/cliente";
import { Empleado } from "../empleados/empleado";
import { Producto } from "../producto/producto";

export class Domicilio{
    idDomicilio: number;
    cliente: Cliente;
    empleado: Empleado;
    producto: Producto;
    codigo: string;
    fecha: Date;
    direccion: string;
    costo: number;
}