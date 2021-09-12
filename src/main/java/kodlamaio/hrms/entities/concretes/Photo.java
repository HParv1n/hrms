package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "photos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "photo_id")
    private Integer photoId;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "image_id")
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
