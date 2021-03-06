package com.gama.CaxaExercise.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.CaxaExercise.dto.AtmDto;
import com.gama.CaxaExercise.entities.Atm;
import com.gama.CaxaExercise.repositories.AtmRepository;
import com.gama.CaxaExercise.services.exceptions.InvalidWithdrawalValueException;

@Service
public class AtmService {
	
	@Autowired
	private AtmRepository repository;

	
	public List<AtmDto> findAll() {
		List<Atm> list = repository.findAll();
		return list.stream().map(x -> new AtmDto(x)).collect(Collectors.toList());
	}

	public AtmDto withdraw(AtmDto dto) {
		Atm entity = new Atm();
		if (dto.getMoneyWithdrawal()<5) throw new InvalidWithdrawalValueException("Valor de saque invalido"); 
			String result=withDrawResult(dto);
			entity.setResult(result);
			copyDtoToEntity(dto,entity);
			entity=repository.save(entity);
			return new AtmDto(entity);	
	}
	
	private String withDrawResult(AtmDto dto) {
		
		int currentNote = dto.getMoneyWithdrawal();        
        int[] arrayNote = new int[] {100,50,20,10,5};
        Map<Integer,Integer> noteMap = new HashMap<>();
        for(int i=0; i < arrayNote.length; i++) {
        	int note = currentNote /arrayNote[i];
        	currentNote -=note *arrayNote[i];
        	noteMap.put(arrayNote[i], note);
        }
        
        String msgFinal ="";
        for (Integer i : noteMap.keySet()) {
        	if(noteMap.get(i) > 0) {
        		String msg = ","+
        				noteMap.get(i) + " notes of "+ i;
        		msgFinal += msg;
        		}
        	}
        return msgFinal;
}

	private void copyDtoToEntity(AtmDto dto, Atm entity) {
		entity.setId(dto.getId());
		entity.setRegisterWithDraw(dto.getRegisterWithDraw());
		entity.setMoneyWithdrawal(dto.getMoneyWithdrawal());
	}

	 
	

}
