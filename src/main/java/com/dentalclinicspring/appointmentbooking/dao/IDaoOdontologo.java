package com.dentalclinicspring.appointmentbooking.dao;

public interface IDaoOdontologo<T> {
    public T agregar(T t);
    public void eliminar(Integer id);
    public T listar(Integer id);
    public T modificar(T t);

}
