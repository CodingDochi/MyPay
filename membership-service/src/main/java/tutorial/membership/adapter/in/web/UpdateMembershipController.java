package tutorial.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.common.WebAdapter;
import tutorial.membership.application.port.in.UpdateMembershipCommand;
import tutorial.membership.domain.Membership;
import tutorial.membership.application.port.in.UpdateMembershipUseCase;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateMembershipController {

    private final UpdateMembershipUseCase updateMembershipUsecase;

    @PutMapping(path = "/membership/update")
    ResponseEntity<Membership> updateMembershipByMemberId(@RequestBody UpdateMembershipRequest membershipToBeUpdated) {
        UpdateMembershipCommand command = UpdateMembershipCommand.builder().membershipId(membershipToBeUpdated.getMemberhipId()).name(membershipToBeUpdated.getName()).address(membershipToBeUpdated.getAddress()).email(membershipToBeUpdated.getEmail()).isValid(membershipToBeUpdated.isValid()).build();

        return ResponseEntity.ok(updateMembershipUsecase.updateMembership(command));
    }
}
