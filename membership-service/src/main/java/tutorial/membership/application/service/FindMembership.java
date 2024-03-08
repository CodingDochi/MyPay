package tutorial.membership.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import tutorial.common.UseCase;
import tutorial.membership.application.port.in.FindMembershipCommand;
import tutorial.membership.application.port.in.FindMembershipUseCase;
import tutorial.membership.domain.Membership;
import tutorial.membership.application.port.out.query.FindMembershipPort;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembership implements FindMembershipUseCase {

    private final FindMembershipPort fport;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        return fport.findMembership(
                new Membership.MembershipId(command.getMembershipId())
        );
    }
}
