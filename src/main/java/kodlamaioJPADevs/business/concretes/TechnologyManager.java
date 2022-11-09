package kodlamaioJPADevs.business.concretes;

import kodlamaioJPADevs.business.abstracts.ITechnologyService;
import kodlamaioJPADevs.business.requests.CreateTechnologyRequest;
import kodlamaioJPADevs.business.requests.UpdateTechnologyRequest;
import kodlamaioJPADevs.business.responses.GetAllTechnologyResponse;
import kodlamaioJPADevs.dataAccess.abstracts.ILanguageRepository;
import kodlamaioJPADevs.dataAccess.abstracts.ITechnologyRepository;
import kodlamaioJPADevs.entities.concretes.Language;
import kodlamaioJPADevs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements ITechnologyService {

    private ITechnologyRepository technologyRepository;
    private ILanguageRepository languageRepository;

    public TechnologyManager(ITechnologyRepository technologyRepository, ILanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        Language programmingLanguage = languageRepository.findById(createTechnologyRequest.getLanguageId()).orElseThrow(() -> new Exception("Programming language id does not exist"));

        Technology subTechnology = new Technology();
        subTechnology.setName(createTechnologyRequest.getName());
        subTechnology.setLanguage(programmingLanguage);
        technologyRepository.save(subTechnology);
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {

        Language programmingLanguage = languageRepository.findById(updateTechnologyRequest.getLanguageId()).orElseThrow(null);
        Technology subTechnology = technologyRepository.findById(updateTechnologyRequest.getId()).orElse(null);
        subTechnology.setName(updateTechnologyRequest.getName());
        subTechnology.setLanguage(programmingLanguage);
        technologyRepository.save(subTechnology);
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> subTechnologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<>();

        for (Technology subTechnology:subTechnologies){
            GetAllTechnologyResponse getAllTechnologyResponse = new GetAllTechnologyResponse();
            getAllTechnologyResponse.setId(subTechnology.getId());
            getAllTechnologyResponse.setName(subTechnology.getName());
            getAllTechnologyResponse.setLanguageId(subTechnology.getLanguage().getId());
            getAllTechnologyResponses.add(getAllTechnologyResponse);
        }
        return getAllTechnologyResponses;
    }
}
