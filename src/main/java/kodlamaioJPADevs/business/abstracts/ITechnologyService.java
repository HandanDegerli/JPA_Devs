package kodlamaioJPADevs.business.abstracts;

import kodlamaioJPADevs.business.requests.CreateTechnologyRequest;
import kodlamaioJPADevs.business.requests.UpdateTechnologyRequest;
import kodlamaioJPADevs.business.responses.GetAllTechnologyResponse;

import java.util.List;

public interface ITechnologyService {
    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void delete(int id);
    void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
    List<GetAllTechnologyResponse> getAll();
}
