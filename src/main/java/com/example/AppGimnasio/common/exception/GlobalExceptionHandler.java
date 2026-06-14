package com.example.AppGimnasio.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //USER EXCEPTIONS
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ProblemDetail handleUserAlreadyExists(
            UserAlreadyExistsException ex
    ){
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.CONFLICT,
                        ex.getMessage()
                );
        problemDetail.setTitle("El usuario ya existe.");
        return problemDetail;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(
            UserNotFoundException ex
    ){

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );
        problemDetail.setTitle("Usuario no encontrado.");

        return problemDetail;
    }

    //ROLE EXCEPTIONS
    @ExceptionHandler(RoleAlreadyExistsException.class)
    public  ProblemDetail handleRoleAlreadyExists(
            RoleAlreadyExistsException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.CONFLICT,
                        ex.getMessage()

                );
        problemDetail.setTitle("El rol ya existe.");

        return problemDetail;
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ProblemDetail handleRoleNotFound(
            RoleNotFoundException ex
    ){

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );
        problemDetail.setTitle("Rol no encontrado.");

        return problemDetail;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex
    ) {

        Throwable cause = ex.getCause();

        if (cause != null &&
                cause.getMessage() != null &&
                cause.getMessage().contains("RoleName")) {

            ProblemDetail problemDetail =
                    ProblemDetail.forStatusAndDetail(
                            HttpStatus.BAD_REQUEST,
                            "Rol inválido. Valores permitidos: ADMIN, TRAINER, CLIENT"
                    );
            problemDetail.setTitle("Rol inválido");
            return problemDetail;
        }

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        "El cuerpo de la petición contiene datos inválidos."
                );

        problemDetail.setTitle("Solicitud inválida.");

        return problemDetail;
    }

    //USER-ROLES EXCEPTIONS
    @ExceptionHandler(UserRoleAlreadyExistsException.class)
    public ProblemDetail handleUserRoleAlreadyExists(
            UserRoleAlreadyExistsException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.CONFLICT,
                        ex.getMessage()
                );
        problemDetail.setTitle("El usuario ya posee ese rol.");

        return problemDetail;
    }

    //CLIENT EXCEPTIONS
    @ExceptionHandler(ClientNotFoundException.class)
    public ProblemDetail handleClientNotFound(
            ClientNotFoundException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );

        problemDetail.setTitle(
                "Perfil de cliente no encontrado."
        );

        return problemDetail;
    }

    //TRAINER EXCEPTIONS
    @ExceptionHandler(TrainerNotFoundException.class)
    public ProblemDetail handleTrainerNotFound(
            TrainerNotFoundException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );

        problemDetail.setTitle(
                "Perfil de entrenador no encontrado"
        );

        return problemDetail;
    }

    //EXERCISE EXCEPTIONS
    @ExceptionHandler(ExerciseAlreadyExistsException.class)
    public ProblemDetail handleExerciseAlreadyExists(
            ExerciseAlreadyExistsException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.CONFLICT,
                        ex.getMessage()
                );

        problemDetail.setTitle(
                "El ejercicio ya existe."
        );

        return problemDetail;
    }

    @ExceptionHandler(ExerciseNotFoundException.class)
    public ProblemDetail handleExerciseNotFound(
            ExerciseNotFoundException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );

        problemDetail.setTitle(
                "Ejercicio no encontrado."
        );

        return problemDetail;
    }

    //PROGRESS EXCEPTIONS
    @ExceptionHandler(ProgressNotFoundException.class)
    public ProblemDetail handleProgressNotFound(
            ProgressNotFoundException ex
    ) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );
        problemDetail.setTitle("Registro de progreso no encontrado.");
        return problemDetail;
    }

    //PAYMENT EXCEPTIONS
    @ExceptionHandler(PaymentNotFoundException.class)
    public ProblemDetail handlePaymentNotFound(
            PaymentNotFoundException ex
    ) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );
        problemDetail.setTitle("Pago no encontrado.");
        return problemDetail;
    }

    //ENROLLMENT EXCEPTIONS
    @ExceptionHandler(EnrollmentNotFoundException.class)
    public ProblemDetail handleEnrollmentNotFound(
            EnrollmentNotFoundException ex
    ) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );
        problemDetail.setTitle("Inscripción no encontrada.");
        return problemDetail;
    }

    //ROUTINE EXCEPTIONS
    @ExceptionHandler(RoutineNotFoundException.class)
    public ProblemDetail handleRoutineNotFound(
            RoutineNotFoundException ex
    ) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                );

        problemDetail.setTitle("Rutina no encontrada.");

        return problemDetail;
    }

    @ExceptionHandler(RoutineAlreadyExistsException.class)
    public ProblemDetail handleRoutineAlreadyExists(
            RoutineAlreadyExistsException ex
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.CONFLICT,
                        ex.getMessage()
                );
        problemDetail.setTitle("La rutina ya existe.");
        return problemDetail;
    }

}

