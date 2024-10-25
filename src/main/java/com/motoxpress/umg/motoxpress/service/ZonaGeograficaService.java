
    
package com.motoxpress.umg.motoxpress.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.motoxpress.umg.motoxpress.model.entity.ZonaGeograficaEntity;
import com.motoxpress.umg.motoxpress.model.repository.ZonaGeograficaRepository;



public class ZonaGeograficaService implements ServiceCRUD<ZonaGeograficaEntity>{

    @Autowired
    private ZonaGeograficaRepository repository;

    @Override
    public ZonaGeograficaEntity createOrUpdate(ZonaGeograficaEntity value) {
        if (value.getId() != null) {
            ZonaGeograficaEntity personaEntity = getFindUncle(value.getId());
            value.setFechaCreacion(personaEntity.getFechaCreacion());
            value.setUsuarioCreo(personaEntity.getUsuarioCreo());
        }
        return repository.save(value);

    }

    @Override
    public List<ZonaGeograficaEntity> getDataList() {
        return (List<ZonaGeograficaEntity>) repository.findAll();
    }

    @Override
    public ZonaGeograficaEntity getFindUncle(Long value) {
       Optional<ZonaGeograficaEntity> res = repository.findById(value);
        return res.isPresent() ? res.get() : null;

    }

    @Override
    public void deleteFind(ZonaGeograficaEntity value) {
        repository.delete(value);
    }

}
