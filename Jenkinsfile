pipeline {
	agent any
	
	environment{
		COMPOSE_PROJECT_NAME='pmng'
		COMPOSE_FILE='docker-compose.yml'
		ENV_FILE= credentials('pmng-env')
	}

	stages {
		stage('Parar servicios'){
			steps{
				echo 'Deteniendo contenedores...'
				sh '''
					docker compose -p ${COMPOSE_PROJECT_NAME} -f ${COMPOSE_FILE} --env-file ${ENV_FILE} down
				'''
			}
		}
		stage('Eliminar imagenes'){
			steps{
				echo 'Eliminando imagenes antiguas...'
				sh '''
					IMAGENES=$(docker compose -p ${COMPOSE_PROJECT_NAME} -f ${COMPOSE_FILE} --env-file ${ENV_FILE} config --images | sort -u)
                    for IMAGE in $IMAGENES; do
                        echo "Eliminando imagen: $IMAGE"
                        docker rmi "$IMAGE" || true
                    done
				'''
			}
		}
		stage('Construir imagenes'){
            steps{
                echo 'Creando nuevas imagenes...'
                sh '''
                    docker compose -p ${COMPOSE_PROJECT_NAME} -f ${COMPOSE_FILE} --env-file ${ENV_FILE} build --no-cache
                '''
            }
        }
		stage('Levantar servicios'){
            steps{
                echo 'Levantando contenedores...'
                sh '''
                    docker compose -p ${COMPOSE_PROJECT_NAME} -f ${COMPOSE_FILE} --env-file ${ENV_FILE} up -d
                '''
            }
        }
	}

	post{
        success{
            echo 'Ejecucion del pipeline finalizada.'
        }
        failure{
            echo 'Error dentro de la ejución del pipeline. Por favor revisa los logs de ejecución.'
        }
    }
}