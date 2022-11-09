package kodlamaioJPADevs.business.concretes;

import kodlamaioJPADevs.business.abstracts.ILanguageService;
import kodlamaioJPADevs.business.requests.CreateLanguageRequest;
import kodlamaioJPADevs.business.requests.UpdateLanguageRequest;
import kodlamaioJPADevs.business.responses.GetAllLanguageResponse;
import kodlamaioJPADevs.dataAccess.abstracts.ILanguageRepository;
import kodlamaioJPADevs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements ILanguageService {

    private ILanguageRepository languageRepository;

    @Autowired
    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

        if (createLanguageRequest.getName().isEmpty() || createLanguageRequest.getName().isBlank()){
            throw new Exception("Programming language name can not be null");
        } else if (languageRepository.existsLanguageByName(createLanguageRequest.getName())) {
            throw new Exception(createLanguageRequest.getName() + "have been already exist!");
        }else{
            Language programmingLanguage = new Language();
            programmingLanguage.setName(createLanguageRequest.getName());
            languageRepository.save(programmingLanguage);
        }
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {

        if(updateLanguageRequest.getName().isEmpty() || updateLanguageRequest.getName().isBlank()){
            throw new Exception("Programming language name can not be null!");
        } else if (languageRepository.existsLanguageByName(updateLanguageRequest.getName())) {
            throw new Exception(updateLanguageRequest.getName() + "have been already exist!");
        }else{
            Language programmingLanguage = languageRepository.findById(updateLanguageRequest.getId()).orElseThrow(() -> new Exception("Id does not exist!"));
            programmingLanguage.setName(updateLanguageRequest.getName());
            languageRepository.save(programmingLanguage);
        }
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> programmingLanguages  = new ArrayList<>();
        List<GetAllLanguageResponse> getProgrammingLanguagesResponses = new ArrayList<>();
        programmingLanguages =languageRepository.findAll();

        for (Language language:programmingLanguages){
            GetAllLanguageResponse getAllLanguageResponse = new GetAllLanguageResponse();
            getAllLanguageResponse.setId(language.getId());
            getAllLanguageResponse.setName(language.getName());
            getProgrammingLanguagesResponses.add(getAllLanguageResponse);
        }
        return getProgrammingLanguagesResponses;
    }

    @Override
    public GetAllLanguageResponse getById(int id) throws Exception {
        Language programmingLanguage = languageRepository.findById(id).orElseThrow(() -> new Exception("ID does not exist"));
        GetAllLanguageResponse getAllLanguageResponse = new GetAllLanguageResponse();
        getAllLanguageResponse.setId(programmingLanguage.getId());
        getAllLanguageResponse.setName(programmingLanguage.getName());
        return getAllLanguageResponse;
    }

}
