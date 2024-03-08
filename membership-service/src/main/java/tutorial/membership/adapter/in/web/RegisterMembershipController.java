package tutorial.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.common.WebAdapter;
import tutorial.membership.application.port.in.RegisterMembershipCommand;
import tutorial.membership.application.port.in.RegisterMembershipUseCase;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

   private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path = "/membership/register")
    void registerMembership(@RequestBody RegisterMembershipRequest request) {
        // name, address, email
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail()).build();

        registerMembershipUseCase.registerMembership(command);

    }

}
