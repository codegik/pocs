# 🧬 Architecture overview

# 1. 🏛️ Structure

## 1.1 🎯 Problem Statement and Context

MR Bill, wants a system to keep track of his favorite pocs, so you need to build a mobile app where mr Bill can register all his pocs, and also he needs to be able to search pocs, by name, by language and by tags.

This system should be multi-tenant because mr bill will sell such system to bunch of people in brazil, such system must have also ability to generate repots and generate a video with the all pocs the users did in 1 year.

Such system must be secure and have proper login and be able to support Realtime dojos using mr bill platform you will build for him.

## 1.2 Restrictions
- Lambda
- Monoliths
- Single AZ Solutions
- Mobile: Ionic
- Single language for mobile - it needs to be “native”
- MongoDB
- Single Relational DB
- Other Clouds that are not AWS

## 1.3 Problem Space

**What is the problem?**
Currently, developers and teams lack a centralized, collaborative platform to track and manage their Proof of Concepts (POCs). 

Most teams resort to scattered solutions like structure of folders in Git, or basic project management tools that don't cater to the specific needs of POC lifecycle management. 

This leads to lost knowledge, duplicated efforts, and missed opportunities for learning and collaboration.

**What is the context of the problem?**
- **Market Context**: The Brazilian tech market is rapidly growing with numerous development teams and freelancers who need better POC management tools
- **Business Context**: Mr. Bill has identified a commercial opportunity to create a SaaS platform that can serve multiple tenants (teams/organizations)
- **Technical Context**: Teams need real-time collaboration capabilities, especially for "dojos" (collaborative coding sessions), which existing tools don't support effectively
- **User Context**: Developers need to quickly search and retrieve POCs by multiple criteria (name, technology stack, tags) to avoid reinventing solutions

**Core Challenges:**
- **Knowledge Silos**: POCs created in isolation without team visibility or collaboration
- **Discovery Problem**: Inability to efficiently search and find relevant POCs when needed
- **Collaboration Gap**: No real-time collaboration tools specifically designed for POC development sessions
- **Documentation Debt**: Lack of standardized reporting and knowledge capture from POC learnings
- **Scalability Need**: Solution must support multiple independent organizations (multi-tenancy) with complete data isolation


# 2. 🎯 Goals

- Build a scalable multi-tenant POC tracking platform
- Provide native mobile applications for iOS and Android
- Implement real-time collaboration for dojos
- Generate automated reports and video summaries
- Ensure high availability across multiple AWS availability zones
- Support secure user authentication and tenant isolation

# 3. 🎯 Non-Goals

- Supporting non-AWS cloud providers
- Building monolithic applications
- Using serverless Lambda functions
- Implementing single-language mobile solutions
- Relying on single relational database
- Support for Legacy Browsers
- Will not build a Git replacement, will integrate with existing version control systems instead.
- Will not use AWS Lambda or other serverless functions.
- Will not build general chat or video conferencing; real-time features are limited to dojo collaboration.
- Will not include POC trading, selling, or commercial marketplace functionality.

# 4. 📐 Principles

- **Multi-tenancy**: Complete tenant isolation for data and users
- **Microservices**: Distributed architecture with independent services
- **Native Mobile**: Platform-specific mobile applications
- **Cloud-Native**: Services designed for AWS cloud infrastructure
- **Real-time**: WebSocket-based communication for live features
- **Security First**: Zero-trust architecture with proper authentication

# 5. 🏗️ Overall Diagrams

## 5.1 🗂️ Overall architecture

TBD 

## 5.2 🗂️ Deployment

- **Multi-AZ AWS deployment**
- **EKS clusters** for container orchestration
- **RDS Multi-AZ** for PostgreSQL databases
- **ElastiCache** for Redis caching
- **S3** for file storage and video assets
- **CloudFront** for CDN distribution

## 5.3 🗂️ Use Cases

- User registration and tenant onboarding
- POC creation, editing, and management
- Search POCs by name, language, and tags
- Real-time dojo collaboration
- Report generation and analytics
- Annual video compilation creation
- User authentication and authorization


# 6. 🧭 Trade-offs

TBD 

## 6.1 Major Decisions

- **Native Mobile vs Cross-platform**: Chose native for better performance and UX
- **Microservices vs Monolith**: Microservices for scalability and maintainability
- **PostgreSQL vs NoSQL**: Relational database for ACID compliance and complex queries
- **Kubernetes vs EC2**: EKS for better container management and scaling
- **Real-time**: WebSockets for immediate updates vs polling for simplicity

## 6.2 🌏 For each key major component

- **Mobile Apps**: Native Android (Kotlin) and iOS (Swift) applications
- **API Gateway**: AWS API Gateway for request routing and rate limiting
- **Authentication Service**: JWT-based auth with tenant isolation
- **POC Management Service**: Core business logic for POC operations
- **Search Service**: Elasticsearch for advanced search capabilities
- **Real-time Service**: WebSocket server for dojo collaboration
- **Report Service**: Background job processing for report generation
- **Video Service**: FFmpeg-based video compilation service
- **Notification Service**: Push notifications and email alerts


# 7. 💾 Migrations

We don't have migration for this architecture since its a new system.

# 8. 🧪 Testing strategy

- **Unit Tests**: Individual service testing with high coverage
- **Integration Tests**: API endpoint and database interaction testing
- **End-to-End Tests**: Mobile app user flow automation
- **Load Testing**: Performance testing for multi-tenant scenarios
- **Security Testing**: Penetration testing and vulnerability assessments
- **Real-time Testing**: WebSocket connection and message delivery testing

# 9. 👀 Observability strategy

- **Logging**: Centralized logging with AWS CloudWatch and ELK stack (Elasticsearch, Logstash, Kibana)
- **Metrics**: Application and infrastructure metrics using CloudWatch, Prometheus, and Grafana
- **Tracing**: Distributed tracing with AWS X-Ray for microservices communication
- **Monitoring**: Real-time alerts and dashboards for system health and performance
- **APM**: Application Performance Monitoring with custom metrics for POC operations
- **Tenant Metrics**: Per-tenant usage analytics and resource consumption tracking
- **Error Tracking**: Automated error detection and alerting with Sentry integration


# 10. 💿 Data Store Designs

- **Primary Database**: PostgreSQL (RDS Multi-AZ) for transactional data
    - Tenant-specific schemas for data isolation
    - POC metadata, user profiles, and tenant configurations
- **Search Database**: Elasticsearch cluster for POC search functionality
    - Indexed by name, language, tags, and content
- **Cache Layer**: Redis (ElastiCache) for session management and frequent queries
- **File Storage**: S3 buckets for POC attachments, videos, and reports
    - Separate buckets per tenant for isolation
- **Time-series Data**: CloudWatch for metrics and monitoring data
- **Message Queue**: SQS for asynchronous processing and video generation jobs


# 11. 🥞 Technology Stack

**Backend Services**:
- **Languages**: Java 17+ with Spring Boot framework
- **Build Tool**: Maven for dependency management and builds
- **Container**: Docker with Kubernetes (EKS) orchestration
- **API**: RESTful APIs with Spring Web and WebSocket support

**Mobile Applications**:
- **Android**: Kotlin with Jetpack Compose
- **iOS**: Swift with SwiftUI
- **Communication**: HTTP/HTTPS with WebSocket for real-time features

**Infrastructure**:
- **Cloud**: AWS (Multi-AZ deployment)
- **Database**: PostgreSQL (RDS), Redis (ElastiCache)
- **Search**: Elasticsearch Service
- **Storage**: S3, CloudFront CDN
- **Messaging**: SQS, SNS for notifications
- **Monitoring**: CloudWatch, X-Ray, Prometheus/Grafana