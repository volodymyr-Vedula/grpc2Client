import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.HelloRequest;
import org.example.HelloResponse;
import org.example.HelloServiceGrpc;

public class ClientGrpc {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());

        channel.shutdown();
    }
}
