package net.javaguides.StudentResultManagement.Controller;


import net.javaguides.StudentResultManagement.Service.ResultService;
import net.javaguides.StudentResultManagement.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        Result result = resultService.getResultById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result createdResult = resultService.createResult(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResult);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> updateResult(@PathVariable Long id, @RequestBody Result result) {
        Result updatedResult = resultService.updateResult(id, result);
        return ResponseEntity.ok(updatedResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}
