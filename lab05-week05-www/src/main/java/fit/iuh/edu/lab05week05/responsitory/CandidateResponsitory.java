package fit.iuh.edu.lab05week05.responsitory;

import fit.iuh.edu.lab05week05.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateResponsitory extends JpaRepository<Candidate,Long> {
}
