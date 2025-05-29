package com.vareli.tecsoft.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vareli.tecsoft.model.QueryDetails;
import com.vareli.tecsoft.model.QueryHeader;
import com.vareli.tecsoft.model.dto.QueryInputDto;
import com.vareli.tecsoft.repository.QueryHeaderRepository;
import com.vareli.tecsoft.response.ResponseHandler;
import com.vareli.tecsoft.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService{

    @Autowired
    private QueryHeaderRepository queryHeaderRepository;



    @Override
    public ResponseEntity<?> addQuery(List<QueryInputDto> inputList) {
       QueryHeader queryHeader = new QueryHeader();
        List<QueryDetails> detailsList = new ArrayList<>();

        for (QueryInputDto dto : inputList) {
            List<String> answers = extractStringList(dto.getAns());
            List<Integer> ansIds = extractIntegerList(dto.getAnsid());

            // Normalize sizes
            int max = Math.max(answers.size(), ansIds.size());
            for (int i = 0; i < max; i++) {
                QueryDetails details = new QueryDetails();
                details.setQsnId(dto.getId());
            
                details.setAns(i < answers.size() ? answers.get(i) : null);
                details.setAnsId(i < ansIds.size() ? ansIds.get(i) : null);
                details.setQueryHeader(queryHeader);
                detailsList.add(details);
            }
        }

        queryHeader.setQueryDetails(detailsList);
        queryHeaderRepository.save(queryHeader);
    return  ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, null);

        
    }

    private List<String> extractStringList(Object obj) {
        if (obj instanceof String) return List.of((String) obj);
        if (obj instanceof List<?>) {
            return ((List<?>) obj).stream().map(String::valueOf).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<Integer> extractIntegerList(Object obj) {
        if (obj instanceof Integer) return List.of((Integer) obj);
        if (obj instanceof List<?>) {
            return ((List<?>) obj).stream().map(o -> (Integer) o).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    
}
