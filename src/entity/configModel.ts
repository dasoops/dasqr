export interface GetConfigParam {
    keyword?: string | undefined;
    description?: string | undefined;
    size: number;
    current: number;
}

export interface ConfigData {
    id: number;
    keyword: string;
    value: string;
    description: string;
}

export interface EditConfigParam {
    id: number;
    keyword: string;
    value: string;
    description: string;
}

export interface AddConfigParam {
    keyword: string;
    value: string;
    description: string;
    canEdit: number;
}

