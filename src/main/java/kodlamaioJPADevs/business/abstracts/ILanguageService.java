package kodlamaioJPADevs.business.abstracts;

import kodlamaioJPADevs.business.requests.CreateLanguageRequest;
import kodlamaioJPADevs.business.requests.UpdateLanguageRequest;
import kodlamaioJPADevs.business.responses.GetAllLanguageResponse;

import java.util.List;

public interface ILanguageService {
    void add(CreateLanguageRequest createLanguageRequest) throws Exception;
    void delete(int id);
    void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
    List<GetAllLanguageResponse> getAll();
    GetAllLanguageResponse getById(int id) throws Exception;
}
