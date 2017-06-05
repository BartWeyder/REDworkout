package xyz.redworkout.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "exercise_info")
public class ExerciseInfo implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "exercise_name", unique = true, nullable = false)
    private String exerciseName;

    @Column(name = "exercise_description")
    private String description;

    @NotEmpty
    @Column (name = "exercise_tags", nullable = false)
    private String tags;

    @Type(type= "org.hibernate.type.NumericBooleanType")
    @Column(name = "public_access", nullable = false)
    private boolean publicAccess = false;

    /**
     * Not sure what cascade type needs to be used here.
     * I make it ALL to change it later if necessary.
     * TODO: solve choice of cascade type.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private User author;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((exerciseName == null) ? 0 : exerciseName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        ExerciseInfo other = (ExerciseInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (exerciseName == null) {
            if (other.exerciseName != null)
                return false;
        } else if (!exerciseName.equals(other.exerciseName))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "ExerciseInfo [id=" + id + ", exerciseName=" + exerciseName + ", description=" + description + ", tags="
                + tags + ", publicAccess=" + publicAccess + "]";
    }
}
