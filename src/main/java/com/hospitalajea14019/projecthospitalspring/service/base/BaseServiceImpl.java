package com.hospitalajea14019.projecthospitalspring.service.base;

import com.hospitalajea14019.projecthospitalspring.exceptions.GeneralServicesExceptions;
import com.hospitalajea14019.projecthospitalspring.exceptions.NoDataFoundExceptions;
import com.hospitalajea14019.projecthospitalspring.exceptions.ValidateServiceExceptions;
import com.hospitalajea14019.projecthospitalspring.model.base.Base;
import com.hospitalajea14019.projecthospitalspring.repository.base.BaseRepository;
import com.hospitalajea14019.projecthospitalspring.validator.BaseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class BaseServiceImpl<E extends Base,ID extends Serializable,V extends BaseValidator<E>> implements BaseService<E,ID>{

    protected BaseRepository<E,ID> baseRepository;

    @Autowired
    private V validator;

    public BaseServiceImpl(BaseRepository<E,ID> baseRepository){
        this.baseRepository=baseRepository;
    }

    @Transactional
    @Override
    public List<E> findAll(){
        try {
            List<E> entity = baseRepository.findAll();
            return entity;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }

    @Transactional
    @Override
    public E findById(ID id) {
        E entity = baseRepository.findById(id)
                            .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
        return entity;
    }

    @Transactional
    @Override
    public E save(E entity) {
        try {
            //validator
            validator.validar(entity);
            return  baseRepository.save(entity);

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    @Transactional
    @Override
    public E update(E entity) {
        try {
            V validator = null;
            validator.validar(entity);
            Optional<E> entityS=baseRepository.findById((ID) entity.getId());
            E entityU=entityS.orElseThrow(()-> new NoDataFoundExceptions("error al actualizar el id: " + entity.getId()));
            entityU=baseRepository.save(entity);
            return entityU;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    @Transactional
    @Override
    public Boolean delete(ID id) {
        try {
            E entityS = baseRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            baseRepository.delete(entityS);
            return true;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }

}
