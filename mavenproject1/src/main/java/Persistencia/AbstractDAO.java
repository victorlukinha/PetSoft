/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author 00685193209
 */
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
@SuppressWarnings("rawtypes")
public abstract class AbstractDAO<Type extends Identificator, ID extends Serializable, Repository extends JpaRepository> {

	@Autowired
	protected Repository repository;

	public long count() {
		return repository.count();
	}

	@SuppressWarnings("unchecked")
	public void delete(Serializable arg0) {
		repository.delete(arg0);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(Serializable arg0) {
		return repository.exists(arg0);
	}

	@SuppressWarnings("unchecked")
	public List<Type> findAll() {
		return repository.findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Type> findAll(Iterable<Serializable> arg0) {
		return repository.findAll(arg0);
	}

	@SuppressWarnings("unchecked")
	public Page<Type> findAll(Pageable arg0) {
		return repository.findAll(arg0);
	}

	@SuppressWarnings("unchecked")
	public List<Type> findAll(Sort arg0) {
		return repository.findAll(arg0);
	}

	@SuppressWarnings("unchecked")
	public Type findOne(Serializable arg0) {
		return (Type) repository.findOne(arg0);
	}

	@SuppressWarnings("unchecked")
	public <S extends Type> Optional<S> save(S newValue) {
		Optional<S> result = Optional.empty();

		if (newValue.getId() == null) {
			// cria novo registro
			result = Optional.ofNullable((S) repository.save(newValue));
		} else {
			// atualiza registro, modificando os valores necessários para atualização.
			S value = (S) this.findOne(newValue.getId());
			((Upgrader<S>) value).update(value, newValue);
			result = Optional.ofNullable((S) repository.save(newValue));
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public <S extends Type> S saveAndFlush(S arg0) {
		return (S) repository.saveAndFlush(arg0);
	}

}