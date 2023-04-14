package com.project.portfolioapp.controller;

//
//@RestController
//public class SessionController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User loginRequest, HttpServletRequest request, HttpServletResponse response) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String sessionId = UUID.randomUUID().toString();
//        RedisConnection redisConnection = redisConnectionFactory.getConnection();
//
//        // Store the session ID in Redis with a TTL of 30 minutes
//        redisConnection.setEx(sessionId.getBytes(), 1800, authentication.getName().getBytes());
//
//        // Set the session ID in a cookie and return it in the response
//        Cookie sessionCookie = new Cookie("SESSIONID", sessionId);
//        sessionCookie.setPath("/");
//        sessionCookie.setHttpOnly(true);
//        response.addCookie(sessionCookie);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/session")
//    public Authentication getSession(Authentication authentication) {
//        return authentication;
//    }
//
//    @GetMapping("/logout")
//    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        String sessionId = getSessionId(request);
//        if (sessionId != null) {
//            RedisConnection redisConnection = redisConnectionFactory.getConnection();
//
//            // Remove the session ID from Redis
//            redisConnection.del(sessionId.getBytes());
//
//            // Remove the session ID cookie from the response
//            Cookie sessionCookie = new Cookie("SESSIONID", "");
//            sessionCookie.setPath("/");
//            sessionCookie.setMaxAge(0);
//            response.addCookie(sessionCookie);
//        }
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//        response.setStatus(HttpStatus.OK.value());
//    }
//
//    private String getSessionId(HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("SESSIONID")) {
//                    return cookie.getValue();
//                }
//            }
//        }
//        return null;
//    }
//}