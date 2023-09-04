package net.snascimento.library.repository;

import net.snascimento.library.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {}
