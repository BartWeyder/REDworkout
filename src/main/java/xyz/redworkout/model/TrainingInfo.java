package xyz.redworkout.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "training_info")
public class TrainingInfo implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "training_description")
    private String trainingDescription;

    //@NotEmpty
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "course_id")
    private CourseInfo course;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "training_exercise_info",
        joinColumns = {@JoinColumn(name = "training_id")},
        inverseJoinColumns = {@JoinColumn(name = "exercise_id")})
    private List<ExerciseInfo> exercises = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    public CourseInfo getCourse() {
        return course;
    }

    public void setCourse(CourseInfo course) {
        this.course = course;
    }

    public List<ExerciseInfo> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseInfo> exercises) {
        this.exercises = exercises;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     *
     * Incorrect because of lack of time.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof TrainingInfo))
            return false;
        TrainingInfo other = (TrainingInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (exercises == null) {
            if (other.exercises != null)
                return false;
        } else if (!exercises.equals(other.exercises))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TrainingInfo [id=" + id + ", trainingName=" + trainingName + ", trainingDescription=" + trainingDescription
                + "]";
    }
}
