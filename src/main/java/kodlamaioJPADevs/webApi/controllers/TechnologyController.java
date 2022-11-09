package kodlamaioJPADevs.webApi.controllers;

import kodlamaioJPADevs.business.abstracts.ITechnologyService;
import kodlamaioJPADevs.business.requests.CreateTechnologyRequest;
import kodlamaioJPADevs.business.requests.UpdateTechnologyRequest;
import kodlamaioJPADevs.business.responses.GetAllTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtechnology")
public class TechnologyController {

    private ITechnologyService technologyService;

    public TechnologyController(ITechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception{
        technologyService.add(createTechnologyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        technologyService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        technologyService.update(updateTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }
}
