package com.dentalclinicspring.appointmentbooking.dao;

public interface IDaoOdontologo<T> {
    public T agregar(T t);
    public void eliminar(Long id);
    public T listar(Long id);

}
