package tutorial.membership.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import tutorial.common.PersistenceAdapter;
import tutorial.membership.application.port.out.query.FindMembershipPort;
import tutorial.membership.application.port.out.query.RegisterMembershipPort;
import tutorial.membership.application.port.out.query.UpdateMembershipPort;
import tutorial.membership.domain.Membership;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, UpdateMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;

    @Override
    public void createMembership(
        Membership.MembershipName memberName,
        Membership.MembershipEmail memberEmail,
        Membership.MembershipAddress memberAddress,
        Membership.MembershipIsValid memberIsValid
    ) {
        membershipRepository.save(
            new MembershipJpaEntity(
                memberName.getMembership_name(),
                memberEmail.getMembership_email(),
                memberAddress.getMembership_address(),
                memberIsValid.isMembership_isValid()
            )
        );
    }

    @Override
    public Membership findMembership(Membership.MembershipId membershipId) {
        return membershipMapper.mapToDomainEntity(
                membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembership_id()))
        );
    }

    @Override
    public Membership updateMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid) {

        // update membership info
        MembershipJpaEntity membershipJpaEntity = membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembership_id()));
        membershipJpaEntity.setName(membershipName.getMembership_name());
        membershipJpaEntity.setEmail(membershipEmail.getMembership_email());
        membershipJpaEntity.setAddress(membershipAddress.getMembership_address());
        membershipJpaEntity.setValid(membershipIsValid.isMembership_isValid());

        // save
        MembershipJpaEntity updatedMembership =
                membershipRepository.save(membershipJpaEntity);

        // return
        return membershipMapper.mapToDomainEntity(updatedMembership);
    }
}
