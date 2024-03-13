package net.javaguides.StudentResultManagement.Service;


import net.javaguides.StudentResultManagement.Repository.ResultRepository;
import net.javaguides.StudentResultManagement.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public Result getResultById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Result not found"));
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
    public Result updateResult(Long id, Result resultDetails) {
        Result result = getResultById(id);
        result.setStudent(resultDetails.getStudent());
        result.setCourse(resultDetails.getCourse());
        result.setGrade(resultDetails.getGrade());
        return resultRepository.save(result);
    }
    // Other methods as needed
}