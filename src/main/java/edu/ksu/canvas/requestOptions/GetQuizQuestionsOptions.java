package edu.ksu.canvas.requestOptions;

import java.util.Arrays;

public class GetQuizQuestionsOptions extends BaseOptions {

    private String courseId;
    private Integer quizId;

    public GetQuizQuestionsOptions(String courseId, Integer quizId) {
        this.courseId = courseId;
        this.quizId = quizId;
    }

    public String getCourseId() {
        return courseId;
    }

    public Integer getQuizId() {
        return quizId;
    }

    /**
     * If specified, this request will return the questions that were presented for the given submission.
     * Useful if the quiz was modified after the submission was created.
     * NOTE: If you specify this parameter, you MUST also specify the quizSubmissionAttempt.
     * @param submissionId Quiz Submission ID to get questions for
     * @return This object to allow adding more options
     */
    public GetQuizQuestionsOptions quizSubmissionId(Integer submissionId) {
        optionsMap.put("quiz_submission_id", Arrays.asList(submissionId.toString()));
        return this;
    }

    /**
     * The attempt of the submission you want the questions for
     * @param submissionAttempt The ID of the submission attempt
     * @return This object to allow adding more options
     */
    public GetQuizQuestionsOptions quizSubmissionAttempt(Integer submissionAttempt) {
        optionsMap.put("quiz_submission_attempt", Arrays.asList(submissionAttempt.toString()));
        return this;
    }

}
