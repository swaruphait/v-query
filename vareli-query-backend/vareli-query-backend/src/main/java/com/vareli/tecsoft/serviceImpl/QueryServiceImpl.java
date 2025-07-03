package com.vareli.tecsoft.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vareli.tecsoft.model.QueryAnswer;
import com.vareli.tecsoft.model.QueryDetails;
import com.vareli.tecsoft.model.QueryHeader;
import com.vareli.tecsoft.model.QuestionList;
import com.vareli.tecsoft.model.dto.QueryInputDto;
import com.vareli.tecsoft.repository.QueryHeaderRepository;
import com.vareli.tecsoft.repository.QuestionListRepository;
import com.vareli.tecsoft.response.ResponseHandler;
import com.vareli.tecsoft.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryHeaderRepository queryHeaderRepository;

    @Autowired
    private QuestionListRepository questionListRepository;

    @Override
    public ResponseEntity<?> addQuery(List<QueryInputDto> inputList) {
        QueryHeader queryHeader = new QueryHeader();
        QueryInputDto firstInput = inputList.get(0);
        Optional<QuestionList> byId = questionListRepository.findById(firstInput.getId());
        queryHeader.setProject(byId.get().getProject());
        queryHeader.setDate(LocalDateTime.now());
        List<QueryDetails> detailsList = new ArrayList<>();
        for (QueryInputDto dto : inputList) {
            QueryDetails details = new QueryDetails();
            details.setQsnId(dto.getId());
            details.setQsn(dto.getQsn()); // Optional: Set actual question text if available
            details.setQueryHeader(queryHeader);

            List<QueryAnswer> answerList = new ArrayList<>();

            // Normalize to list
            List<String> ansList = dto.getAns() != null ? dto.getAns() : new ArrayList<>();
            List<Long> ansIdList = dto.getAnsid() != null ? dto.getAnsid() : new ArrayList<>();

            int max = Math.max(ansList.size(), ansIdList.size());

            for (int i = 0; i < max; i++) {
                QueryAnswer answer = new QueryAnswer();
                answer.setAns(i < ansList.size() ? ansList.get(i) : null);
                answer.setAnsId(i < ansIdList.size() ? String.valueOf(ansIdList.get(i)) : null);
                answer.setQueryDetails(details);
                answerList.add(answer);
            }

            details.setQueryAnswers(answerList);
            detailsList.add(details);
        }

        queryHeader.setQueryDetails(detailsList);
        queryHeaderRepository.save(queryHeader);

        return ResponseHandler.generateResponse("Successfully saved details!", HttpStatus.OK, null);

    }

    @Override
    public ResponseEntity<?> fetchAllQuery() {
        List<QueryHeader> all = queryHeaderRepository.findAll();
        return ResponseHandler.generateResponse("Successfully Featch details!", HttpStatus.OK, all);
    }

    @Override
    public ResponseEntity<?> fetchQueryData(String name) {
        List<QueryHeader> allByProject = queryHeaderRepository.findAllByProject(name);
        return ResponseHandler.generateResponse("Successfully Featch details!", HttpStatus.OK, allByProject);
    }

}
