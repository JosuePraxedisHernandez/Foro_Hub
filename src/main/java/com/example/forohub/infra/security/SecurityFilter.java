package com.example.forohub.infra.security;

import com.example.forohub.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter{
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("FILTRO LLamado!");
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null){
            //obtener el token ; luego a buscar en la base de datos
            var subject = tokenService.getSubject(tokenJWT);
            var usuario =   repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null,usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Usuario Logeado!");
        }


        filterChain.doFilter(request,response);

    }
    //obtener encabezado si tiene o no
    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null ){
            return authorizationHeader.replace("Bearer ","");
        }
        return null;

    }
}
