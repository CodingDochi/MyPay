package tutorial.membership.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import tutorial.common.UseCase;
import tutorial.membership.application.port.in.UpdateMembershipCommand;
import tutorial.membership.application.port.in.UpdateMembershipUseCase;
import tutorial.membership.application.port.out.query.FindMembershipPort;
import tutorial.membership.application.port.out.query.UpdateMembershipPort;
import tutorial.membership.domain.Membership;

@RequiredArgsConstructor
@UseCase
@Transactional
public class UpdateMembership implements UpdateMembershipUseCase {
    private final UpdateMembershipPort uport;
    private final FindMembershipPort fport;

    @Override
    public Membership updateMembership(UpdateMembershipCommand command) {
        return uport.updateMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid())
        );
    }
}
