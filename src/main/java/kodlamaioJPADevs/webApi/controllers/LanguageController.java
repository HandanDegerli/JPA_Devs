package kodlamaioJPADevs.webApi.controllers;

import kodlamaioJPADevs.business.abstracts.ILanguageService;
import kodlamaioJPADevs.business.requests.CreateLanguageRequest;
import kodlamaioJPADevs.business.requests.UpdateLanguageRequest;
import kodlamaioJPADevs.business.responses.GetAllLanguageResponse;
import kodlamaioJPADevs.entities.concretes.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class LanguageController {

    private ILanguageService languageService;

    public LanguageController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.add(createLanguageRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id){
        languageService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception{
        languageService.update(updateLanguageRequest);
    }

    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public GetAllLanguageResponse getById(@PathVariable int id) throws Exception{
        return languageService.getById(id);
    }
}
