package tutorial.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tutorial.common.WebAdapter;
import tutorial.membership.application.port.in.FindMembershipCommand;
import tutorial.membership.application.port.in.FindMembershipUseCase;
import tutorial.membership.domain.Membership;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping(path = "/membership/{membershipId}" )
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand.builder().membershipId(membershipId).build();
        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }
}
