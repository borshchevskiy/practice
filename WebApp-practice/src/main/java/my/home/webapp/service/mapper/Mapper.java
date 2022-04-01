package my.home.webapp.service.mapper;

public interface Mapper <F, T>{
    T mapFrom(F object);
}
