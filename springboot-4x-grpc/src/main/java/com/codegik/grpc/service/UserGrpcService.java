package com.codegik.grpc.service;

import com.codegik.grpc.model.User;
import com.codegik.grpc.proto.*;
import com.codegik.grpc.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    private final UserRepository userRepository;

    public UserGrpcService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User savedUser = userRepository.save(user);

        UserResponse response = UserResponse.newBuilder()
                .setUser(convertToProtoUser(savedUser))
                .setMessage("User created successfully")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(GetUserRequest request, StreamObserver<UserResponse> responseObserver) {
        Optional<User> userOpt = userRepository.findById(request.getId());

        if (userOpt.isPresent()) {
            UserResponse response = UserResponse.newBuilder()
                    .setUser(convertToProtoUser(userOpt.get()))
                    .setMessage("User found")
                    .build();
            responseObserver.onNext(response);
        } else {
            UserResponse response = UserResponse.newBuilder()
                    .setMessage("User not found")
                    .build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UserResponse> responseObserver) {
        Optional<User> userOpt = userRepository.findById(request.getId());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(request.getName());
            user.setEmail(request.getEmail());

            User updatedUser = userRepository.save(user);

            UserResponse response = UserResponse.newBuilder()
                    .setUser(convertToProtoUser(updatedUser))
                    .setMessage("User updated successfully")
                    .build();
            responseObserver.onNext(response);
        } else {
            UserResponse response = UserResponse.newBuilder()
                    .setMessage("User not found")
                    .build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
        boolean exists = userRepository.existsById(request.getId());

        if (exists) {
            userRepository.deleteById(request.getId());
            DeleteUserResponse response = DeleteUserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User deleted successfully")
                    .build();
            responseObserver.onNext(response);
        } else {
            DeleteUserResponse response = DeleteUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("User not found")
                    .build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }

    @Override
    public void listUsers(ListUsersRequest request, StreamObserver<ListUsersResponse> responseObserver) {
        var users = userRepository.findAll();

        ListUsersResponse.Builder responseBuilder = ListUsersResponse.newBuilder();
        users.forEach(user -> responseBuilder.addUsers(convertToProtoUser(user)));

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    private com.codegik.grpc.proto.User convertToProtoUser(User user) {
        return com.codegik.grpc.proto.User.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail())
                .build();
    }
}
