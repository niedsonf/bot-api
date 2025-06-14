package br.com.botapi.repository.firebase;

import br.com.botapi.dto.FirebaseUserDTO;
import br.com.botapi.model.User;
import br.com.botapi.repository.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class FirebaseUserRepository implements UserRepository {
    private static final String USERS_COLLECTION = "users";

    @Inject
    Firestore firestore;

    @Override
    public void create(User user) {
        try {
            ApiFuture<WriteResult> future = firestore
                    .collection(USERS_COLLECTION)
                    .document(user.getJid())
                    .set(FirebaseUserDTO.fromDomain(user));
            future.get();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuário", e);
        }
    }

    @Override
    public User findByJid(String jid) {
        try {
            DocumentReference docRef = firestore.collection(USERS_COLLECTION).document(jid);
            DocumentSnapshot snapshot = docRef.get().get();
            FirebaseUserDTO firebaseUserDTO = snapshot.toObject(FirebaseUserDTO.class);
            return (snapshot.exists() && firebaseUserDTO != null) ? firebaseUserDTO.toDomain() : null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuário", e);
        }
    }

    @Override
    public void update(User user) {
        try {
            ApiFuture<WriteResult> future = firestore
                    .collection(USERS_COLLECTION)
                    .document(user.getJid())
                    .set(FirebaseUserDTO.fromDomain(user));
            future.get();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuário", e);
        }
    }
}
